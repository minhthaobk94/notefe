import { SegmentType } from "./SegmentType";

export interface Segment {
  id: number;
  index: number;
  text: string;
  segmentType: SegmentType;
  translations: any[];
}
