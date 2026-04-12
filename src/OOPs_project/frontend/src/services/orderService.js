import { dummyData } from "../constants/dummyData";
import { createMockResponse } from "./api";

export function getOrders() {
  return createMockResponse(dummyData.orderHistory);
}
