import { useState } from "react";
import Button from "../../components/common/Button";
import AddressForm from "../../components/forms/AddressForm";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";
import formatCurrency from "../../utils/formatCurrency";

export default function Checkout() {
  const [selectedAddress, setSelectedAddress] = useState(dummyData.checkoutAddresses[0]?.id);
  const [selectedDelivery, setSelectedDelivery] = useState(dummyData.deliveryOptions[0]?.id);
  const [selectedPayment, setSelectedPayment] = useState(dummyData.paymentMethods[2]?.id);

  const subtotal = dummyData.cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);
  const couponDiscount = 200;
  const selectedDeliveryOption = dummyData.deliveryOptions.find((item) => item.id === selectedDelivery);
  const shipping = selectedDeliveryOption?.price ?? 0;
  const walletUsed = selectedPayment === "wallet" ? 1250 : 0;
  const finalTotal = subtotal + shipping - couponDiscount - walletUsed;

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/app/cart">Back to cart</Button>}
          eyebrow="Checkout"
          title="Finalize your order with confidence"
          description="This screen should feel calm and trustworthy: clear delivery details, flexible payment options, and one sharp final confirmation state."
        />

        <section className="grid gap-6 lg:grid-cols-3">
          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-brand-300 p-6 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Items in order</p>
            <h2 className="mt-4 text-4xl font-semibold">{dummyData.cartItems.length}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">All premium items from your cart are ready for confirmation.</p>
          </article>
          <article className="rounded-[2rem] bg-gradient-to-br from-emerald-500 to-emerald-300 p-6 text-white shadow-[var(--shadow-soft-lg)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Wallet applied</p>
            <h2 className="mt-4 text-4xl font-semibold">{formatCurrency(walletUsed)}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">Using stored balance keeps the final payment lighter and faster.</p>
          </article>
          <article className="rounded-[2rem] bg-gradient-to-br from-ink-900 to-ink-700 p-6 text-white shadow-[var(--shadow-soft-lg)]">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/78">Payable now</p>
            <h2 className="mt-4 text-4xl font-semibold">{formatCurrency(finalTotal)}</h2>
            <p className="mt-3 text-sm leading-6 text-white/80">Final amount after coupon, delivery selection, and wallet usage.</p>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.15fr_0.85fr]">
          <div className="space-y-6">
            <AddressForm
              addresses={dummyData.checkoutAddresses}
              onSelect={setSelectedAddress}
              selectedId={selectedAddress}
            />

            <article className="surface-card p-6 md:p-7">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Delivery method</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Choose the shipping experience</h2>
              <div className="mt-8 grid gap-4">
                {dummyData.deliveryOptions.map((option) => {
                  const isSelected = option.id === selectedDelivery;

                  return (
                    <button
                      key={option.id}
                      className={`rounded-[1.75rem] border p-5 text-left transition ${
                        isSelected
                          ? "border-brand-300 bg-brand-50 shadow-[var(--shadow-soft-md)]"
                          : "border-ink-100 bg-ink-50 hover:bg-white"
                      }`}
                      onClick={() => setSelectedDelivery(option.id)}
                      type="button"
                    >
                      <div className="flex items-start justify-between gap-4">
                        <div>
                          <p className="text-lg font-semibold text-ink-900">{option.label}</p>
                          <p className="mt-2 text-sm leading-7 text-ink-500">{option.note}</p>
                        </div>
                        <span className="rounded-full bg-white px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-ink-500">
                          {option.price === 0 ? "Free" : formatCurrency(option.price)}
                        </span>
                      </div>
                    </button>
                  );
                })}
              </div>
            </article>

            <article className="surface-card p-6 md:p-7">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Payment method</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">How should this order be paid</h2>
              <div className="mt-8 grid gap-4">
                {dummyData.paymentMethods.map((method) => {
                  const isSelected = method.id === selectedPayment;

                  return (
                    <button
                      key={method.id}
                      className={`rounded-[1.75rem] border p-5 text-left transition ${
                        isSelected
                          ? "border-brand-300 bg-brand-50 shadow-[var(--shadow-soft-md)]"
                          : "border-ink-100 bg-ink-50 hover:bg-white"
                      }`}
                      onClick={() => setSelectedPayment(method.id)}
                      type="button"
                    >
                      <div className="flex items-start justify-between gap-4">
                        <div>
                          <p className="text-lg font-semibold text-ink-900">{method.label}</p>
                          <p className="mt-2 text-sm leading-7 text-ink-500">{method.note}</p>
                        </div>
                        <span className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${method.accent}`}>
                          {isSelected ? "Selected" : "Available"}
                        </span>
                      </div>
                    </button>
                  );
                })}
              </div>
            </article>
          </div>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Final review</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Order payment summary</h2>

              <div className="mt-8 space-y-4">
                {dummyData.cartItems.map((item) => (
                  <div key={item.id} className="flex items-center justify-between gap-4 rounded-[1.25rem] bg-ink-50 px-4 py-4">
                    <div>
                      <p className="text-sm font-semibold text-ink-900">{item.title}</p>
                      <p className="mt-1 text-xs uppercase tracking-[0.16em] text-ink-300">
                        Qty {item.quantity} · {item.variant}
                      </p>
                    </div>
                    <p className="text-sm font-semibold text-ink-900">{formatCurrency(item.price * item.quantity)}</p>
                  </div>
                ))}
              </div>

              <div className="mt-8 space-y-4 text-sm">
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Subtotal</span>
                  <span className="font-semibold text-ink-900">{formatCurrency(subtotal)}</span>
                </div>
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Delivery</span>
                  <span className="font-semibold text-ink-900">{shipping === 0 ? "Free" : formatCurrency(shipping)}</span>
                </div>
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Coupon applied</span>
                  <span className="font-semibold text-emerald-600">-{formatCurrency(couponDiscount)}</span>
                </div>
                <div className="flex items-center justify-between">
                  <span className="text-ink-500">Wallet used</span>
                  <span className="font-semibold text-emerald-600">-{formatCurrency(walletUsed)}</span>
                </div>
                <div className="border-t border-ink-100 pt-4">
                  <div className="flex items-center justify-between">
                    <span className="text-base font-semibold text-ink-900">Total payable</span>
                    <span className="text-2xl font-semibold text-ink-900">{formatCurrency(finalTotal)}</span>
                  </div>
                </div>
              </div>

              <Button className="mt-8 w-full">Place secure order</Button>
              <Button className="mt-3 w-full" tone="secondary" to="/app/cart">
                Review cart again
              </Button>
            </article>

            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Security and trust</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Why users feel safe here</h2>
              <div className="mt-8 space-y-4">
                {dummyData.checkoutTrustNotes.map((note) => (
                  <div key={note} className="flex items-start gap-3 rounded-[1.25rem] bg-ink-50 p-4">
                    <span className="mt-1 h-2.5 w-2.5 rounded-full bg-brand-500" />
                    <p className="text-sm leading-6 text-ink-600">{note}</p>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Flow status</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Core buying journey is now complete</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                After this, the next strongest work is polishing wallet, notifications, profile, and the public landing so the product feels fully rounded.
              </p>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
