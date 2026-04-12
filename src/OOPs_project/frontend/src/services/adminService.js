import { dummyData } from "../constants/dummyData";
import { createMockResponse } from "./api";

export function getAdminOverview() {
  return createMockResponse({
    stats: dummyData.adminStats,
    queues: dummyData.adminQueues,
  });
}
