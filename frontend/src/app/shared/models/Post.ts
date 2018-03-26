import { Segment } from './Segment';
import { Vocabulary } from "./Vocabulary";

export interface Post {
  id: number;
  segmentIndex: number;
  segments: Segment[];
  vocabularies: Vocabulary[];
  nhkEasyId: string;
  link: string;
  submitted: Date;
  imageURL: string;
  audioURL: string;
}
