import {
  Component,
  OnInit
} from '@angular/core';
import { PostService } from '../service/post.service';
import { Post } from '../shared/models/Post';
import { Segment } from '../shared/models/Segment';
import { saveAs } from 'file-saver/FileSaver';
import { Vocabulary } from "../shared/models/Vocabulary";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts: Post[];
  selectedPost: Post;
  translations: string[];
  showPreview: boolean = false;

  constructor(private postService: PostService) {
  }

  ngOnInit() {
    this.getPosts();
    this.translations = [];
  }

  getPosts(): void {
    this.postService.getPosts().subscribe(posts => this.posts = posts);
  }

  getPostTitle(post: Post): string {
    const segment: Segment = post.segments.find(function (s) {
      return s.segmentType.text === 'title';
    });
    return segment.text;
  }

  getPostTitleWithDatePrefix(post: Post): string {
    if (post != null) {
      const submittedDate: Date = new Date(post.submitted);
      return '[' + submittedDate.getDate() + '-' + (Number)(submittedDate.getMonth() + 1) + '-' + submittedDate.getFullYear() + ']' + this.getPostTitle(post);
    }
    return '';
  }

  onSelect(post: Post) {
    this.selectedPost = post;
    this.translations = [];
  }

  onShowPreview(): void {
    this.updateTranslations();

    this.showPreview = !this.showPreview;
  }

  onSubmit(): void {
    this.updateTranslations();

    this.saveToFileSystem(this.buildTextContent(this.selectedPost));
    console.log(this.buildTextContent(this.selectedPost));
  }

  saveToFileSystem(content: string) {
    const blob = new Blob([content], {type: 'text/plain'});
    saveAs(blob, this.getPostTitleWithDatePrefix(this.selectedPost) + '.txt');
  }

  updateTranslations() {
    let segments = this.selectedPost.segments;
    for (let segment of segments) {
      if (!segment.translations) {
        segment.translations = [];
      }
      segment.translations[0] = this.translations[segment.index];
    }
  }

  buildTextContent(post: Post): string {
    let result: string = '';
    let index: number = 0;
    for (let segment of post.segments) {
      if (index == 1) {
        result = result + this.buildVocabularyListText(post.vocabularies);
        result = result + "\n";
      }

      result = result + segment.text;
      result = result + "\n";
      result = result + segment.viTranslation;
      result = result + "\n\n";

      index++;
    }
    result = result + post.link;
    result = result + "\n\n";

    return result;
  }

  buildVocabularyListText(vocabularyList: Vocabulary[]): string {
    let result: string = '';
    for (let vocab of vocabularyList) {
      if (vocab != null && vocab.text != null && vocab.katakana != null && vocab.viTranslation != null) {
        result = vocab.text == vocab.katakana
          ? result + vocab.text + ': ' + vocab.viTranslation
          : result + vocab.text + ' - ' + vocab.katakana + ': ' + vocab.viTranslation;
      }
      result = result + "\n";
    }
    return result;
  }

}
