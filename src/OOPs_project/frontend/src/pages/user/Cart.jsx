import { useState } from "react";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import CouponForm from "../../components/forms/CouponForm";
import { dummyData } from "../../constants/dummyData";
import calculateDiscount from "../../utils/calculateDiscount";
import formatCurrency from "../../utils/formatCurrency";

function QuantityButton({ children, onClick }) {
  return (
    <button
      className="inline-flex h-10 w-10 items-center justify-center rounded-2xl bg-white text-lg font-semibold text-ink-600 shadow-[var(--shadow-soft-md)] transition hover:text-ink-900"
      onClick={onClick}
      type="button"
    >
      {children}
    </button>
  );
}

export default function Cart() {
  const [couponCode, setCouponCode] = useState("FIRST20");
  const [appliedCoupon, setAppliedCoupon] = useState("FIRST20");
  const [cartItems, setCartItems] = useState(dummyData.cartItems);

  const updateQuantity = (id, direction) => {
    setCartItems((current) =>
      current.map((item) =>
        item.id === id
          ? {
              ...item,
              quantity: direction === "increase" ? item.quantity + 1 : Math.max(1, item.quantity - 1),
            }
          : item
      )
    );
  };

  const subtotal = cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);
  const shipping = subtotal >= 4999 ? 0 : 199;
  const discount = appliedCoupon === "FIRST20" ? 200 : 0;
  const total = subtotal + shipping - discount;

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/checkout">Proceed to checkout</Button>}
          eyebrow="Cart"
          title="Review your cart before checkout"
          description="Use this page to tune quantities, apply rewards or coupon codes, and confirm the final order value before placing the purchase."
        />

        <section className="grid gap-6 lg:grid-cols-3">
          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-brand-300 p-6 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Cart items</p>
            <h2 className="mt-4 text-4xl font-semibold">{cartItems.length}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">Premium picks currently active in your checkout flow.</p>
          </article>
          <article className="rounded-[2rem] bg-gradient-to-br from-emerald-500 to-emerald-300 p-6 text-white shadow-[var(--shadow-soft-lg)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Savings unlocked</p>
            <h2 className="mt-4 text-4xl font-semibold">{formatCurrency(discount)}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">Coupon and pricing advantage already applied to this basket.</p>
          </article>
          <article className="rounded-[2rem] bg-gradient-to-br from-ink-900 to-ink-700 p-6 text-white shadow-[var(--shadow-soft-lg)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Checkout total</p>
            <h2 className="mt-4 text-4xl font-semibold">{formatCurrency(total)}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">Final payable amount including shipping and discounts.</p>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <div className="space-y-6">
            {cartItems.map((item) => {
              const itemDiscount = calculateDiscount({
                currentPrice: item.price,
                originalPrice: item.originalPrice,
              });

              return (
                <article
                  key={item.id}
                  className={`rounded-[2rem] border border-white/70 bg-gradient-to-br ${item.accent} p-6 shadow-[var(--shadow-soft-lg)] md:p-7`}
                >
                  <div className="flex flex-col gap-6 lg:flex-row lg:items-center lg:justify-between">
                    <div className="flex items-start gap-5">
                      <div className="flex h-24 w-24 items-center justify-center rounded-[1.75rem] bg-white text-brand-500 shadow-[var(--shadow-soft-md)]">
                        <svg className="h-11 w-11" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
                          <path d="M4 7h16l-1.5 11h-13z" />
                          <path d="M9 7a3 3 0 0 1 6 0" />
                        </svg>
                      </div>
                      <div>
                        <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">{item.category}</p>
                        <h2 className="mt-3 text-2xl font-semibold text-ink-900">{item.title}</h2>
                        <p className="mt-2 text-sm text-ink-500">Variant: {item.variant}</p>
                        <div className="mt-5 flex flex-wrap items-center gap-3">
                          <p className="text-2xl font-semibold text-ink-900">{formatCurrency(item.price)}</p>
                          <p className="text-sm text-ink-300 line-through">{formatCurrency(item.originalPrice)}</p>
                          <span className="rounded-full bg-emerald-50 px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-emerald-600">
                            {itemDiscount}% off
                          </span>
                        </div>
                      </div>
                    </div>

                    <div className="space-y-4">
                      <div className="flex items-center gap-3 rounded-[1.5rem] bg-white/70 p-3 shadow-[var(--shadow-soft-md)]">
                        <QuantityButton onClick={() => updateQuantity(item.id, "decrease")}>-</QuantityButton>
                        <span className="min-w-10 text-center text-lg font-semibold text-ink-900">{item.quantity}</span>
                        <QuantityButton onClick={() => updateQuantity(item.id, "increase")}>+</QuantityButton>
                      </div>
                      <div className="flex gap-3">
                        <Button tone="secondary">Save for later</Button>
                        <Button tone="ghost">Remove</Button>
                      </div>
                    </div>
                  </div>
                </article>
              );
            })}

            <CouponForm
              onApply={() => setAppliedCoupon(couponCode)}
              onChange={(event) => setCouponCode(event.target.value)}
              suggestions={dummyData.availableCoupons}
              successMessage={appliedCoupon ? `Coupon "${appliedCoupon}" applied successfully.` : ""}
              value={couponCode}
            />
          </div>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Order summary</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Final payment snapshot</h2>

              <div className="mt-8 space-y-4 text-sm">
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Subtotal</span>
                  <span className="font-semibold text-ink-900">{formatCurrency(subtotal)}</span>
                </div>
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Shipping</span>
                  <span className="font-semibold text-ink-900">{shipping === 0 ? "Free" : formatCurrency(shipping)}</span>
                </div>
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Coupon discount</span>
                  <span className="font-semibold text-emerald-600">-{formatCurrency(discount)}</span>
                </div>
                <div className="border-t border-ink-100 pt-4">
                  <div className="flex items-center justify-between">
                    <span className="text-base font-semibold text-ink-900">Total</span>
                    <span className="text-2xl font-semibold text-ink-900">{formatCurrency(total)}</span>
                  </div>
                </div>
              </div>

              <Button className="mt-8 w-full" to="/checkout">
                Continue to checkout
              </Button>
              <Button className="mt-3 w-full" tone="secondary" to="/shop">
                Add more products
              </Button>
            </article>

            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Checkout benefits</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Why this flow feels premium</h2>
              <div className="mt-8 space-y-4">
                {dummyData.shippingBenefits.map((benefit) => (
                  <div key={benefit} className="flex items-start gap-3 rounded-[1.25rem] bg-ink-50 p-4">
                    <span className="mt-1 h-2.5 w-2.5 rounded-full bg-brand-500" />
                    <p className="text-sm leading-6 text-ink-600">{benefit}</p>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Next screen</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Checkout should now feel inevitable</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                Cart clarity reduces friction. The next step is a premium checkout page with address selection, payment methods, and final confirmation.
              </p>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
