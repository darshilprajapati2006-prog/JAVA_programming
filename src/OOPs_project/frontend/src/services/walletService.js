import { dummyData } from "../constants/dummyData";
import { createMockResponse } from "./api";

export function getWalletSummary() {
  return createMockResponse({
    summary: dummyData.walletSummary,
    coupons: dummyData.walletCoupons,
    transactions: dummyData.walletTransactions,
  });
}
