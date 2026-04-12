import { useState } from "react";
import { dummyData } from "../constants/dummyData";

export default function useCart(initialItems = dummyData.cartItems) {
  const [items, setItems] = useState(initialItems);

  const addItem = (item) => setItems((current) => [...current, item]);
  const removeItem = (id) => setItems((current) => current.filter((item) => item.id !== id));
  const clearCart = () => setItems([]);

  return {
    items,
    count: items.reduce((sum, item) => sum + (item.quantity ?? 1), 0),
    addItem,
    removeItem,
    clearCart,
  };
}
