import { Segment } from './Segment';

export interface Post {
  id: number;
  segments: Segment[];
  link: string;
  submitted: Date;
  imageURL: string;
  audioURL: string;
}
