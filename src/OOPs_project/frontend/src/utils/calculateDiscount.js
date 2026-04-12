export default function calculateDiscount(value) {
  const { currentPrice, originalPrice } = value ?? {};

  if (!currentPrice || !originalPrice || currentPrice >= originalPrice) {
    return 0;
  }

  return Math.round(((originalPrice - currentPrice) / originalPrice) * 100);
}
