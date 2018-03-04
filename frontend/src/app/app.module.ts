import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PostsComponent } from './posts/posts.component';
import { PostService } from './service/post.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { ClipboardModule } from 'ngx-clipboard';

@NgModule({
  declarations: [
    AppComponent,
    PostsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ClipboardModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
