import { Segment } from './Segment';

export interface Post {
  id: number;
  segments: Segment[];
  link: string;
  submitted: any;
  imageURL: string;
  audioURL: string;
}
