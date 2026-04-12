import { dummyData } from "../constants/dummyData";
import { createMockResponse } from "./api";

export function getProducts() {
  return createMockResponse(dummyData.productCatalog);
}
