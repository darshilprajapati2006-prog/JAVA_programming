import { authInitialState } from "./slices/authSlice";
import { cartInitialState } from "./slices/cartSlice";
import { productInitialState } from "./slices/productSlice";
import { uiInitialState } from "./slices/uiSlice";

export const mockStore = {
  auth: authInitialState,
  cart: cartInitialState,
  products: productInitialState,
  ui: uiInitialState,
};
