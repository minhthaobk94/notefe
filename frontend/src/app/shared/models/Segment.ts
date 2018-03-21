import { SegmentType } from './SegmentType';

export interface Segment {
  id: number;
  index: number;
  text: string;
  viTranslation: string;
  segmentType: SegmentType;
  translations: any[];
}
