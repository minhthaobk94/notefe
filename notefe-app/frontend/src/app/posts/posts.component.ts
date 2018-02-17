import {
  Component,
  OnInit
} from '@angular/core';
import { PostService } from "../service/post.service";
import { Post } from "../shared/models/Post";

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

  onSelect(post: Post) {
    this.selectedPost = post;
  }

}
