import { Injectable } from '@angular/core';
import { Post } from '../shared/models/Post';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PostService {

  posts: Post[];
  private postUrl = 'api/post';

  constructor(private http: HttpClient) {
  }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.postUrl);
  }

}
