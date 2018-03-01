import {
  Component,
  OnInit
} from '@angular/core';
import { PostService } from '../service/post.service';
import { Post } from '../shared/models/Post';
import { Segment } from '../shared/models/Segment';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts: Post[];
  selectedPost: Post;

  constructor(private postService: PostService) {
  }

  ngOnInit() {
    this.getPosts();
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

  onSelect(post: Post) {
    this.selectedPost = post;
  }

}
