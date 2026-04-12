import { dummyData } from "../constants/dummyData";
import { createMockResponse } from "./api";

export function getCart() {
  return createMockResponse(dummyData.cartItems);
}
