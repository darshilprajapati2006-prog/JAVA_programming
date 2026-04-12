import { useState } from "react";
import OrderCard from "../../components/cards/OrderCard";
import StatCard from "../../components/cards/StatCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Orders() {
  const [activeFilter, setActiveFilter] = useState("All Orders");

  const filteredOrders =
    activeFilter === "All Orders"
      ? dummyData.orderHistory
      : dummyData.orderHistory.filter((order) => order.status === activeFilter);

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/shop">Shop More Products</Button>}
          eyebrow="Orders"
          title="Manage every order with clarity"
          description="Track delivery progress, review payments, and quickly jump back into reordering from a polished command center."
        />

        <section className="grid gap-5 md:grid-cols-2 xl:grid-cols-4">
          {dummyData.orderSummary.map((item) => (
            <StatCard
              key={item.label}
              title={item.label}
              value={item.value}
              change={item.note}
              description="Live from your order history"
              tone={item.tone}
            />
          ))}
        </section>

        <section className="surface-card p-6 md:p-8">
          <div className="flex flex-col gap-5 lg:flex-row lg:items-center lg:justify-between">
            <div>
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Filter queue</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Switch between order states instantly</h2>
            </div>
            <div className="flex flex-wrap gap-3">
              {dummyData.orderFilters.map((filter) => {
                const isActive = activeFilter === filter;

                return (
                  <button
                    key={filter}
                    className={`rounded-full px-5 py-3 text-sm font-semibold transition ${
                      isActive
                        ? "bg-ink-900 text-white shadow-[var(--shadow-soft-md)]"
                        : "bg-ink-50 text-ink-500 hover:bg-white hover:text-ink-900"
                    }`}
                    onClick={() => setActiveFilter(filter)}
                    type="button"
                  >
                    {filter}
                  </button>
                );
              })}
            </div>
          </div>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.3fr_0.7fr]">
          <div className="space-y-5">
            {filteredOrders.map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}

            {filteredOrders.length === 0 ? (
              <div className="surface-card p-10 text-center">
                <p className="text-lg font-semibold text-ink-900">No orders found for this state</p>
                <p className="mt-3 text-ink-500">Try a different filter or continue shopping to generate new activity.</p>
              </div>
            ) : null}
          </div>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Fulfillment flow</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Current order pipeline</h2>
              <div className="mt-8 space-y-5">
                {[
                  { step: "Order placed", note: "Checkout and payment captured", done: true },
                  { step: "Packed carefully", note: "Quality checked before dispatch", done: true },
                  { step: "Shipped", note: "Courier partner moving your package", done: true },
                  { step: "Delivered", note: "Final doorstep handoff", done: false },
                ].map((item, index) => (
                  <div key={item.step} className="flex gap-4">
                    <div className="flex flex-col items-center">
                      <span
                        className={`mt-1 h-4 w-4 rounded-full ${item.done ? "bg-brand-500" : "border-2 border-ink-200 bg-white"}`}
                      />
                      {index < 3 ? <span className="mt-2 h-12 w-px bg-ink-100" /> : null}
                    </div>
                    <div>
                      <p className="text-base font-semibold text-ink-900">{item.step}</p>
                      <p className="mt-1 text-sm leading-6 text-ink-500">{item.note}</p>
                    </div>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-brand-300 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.28)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/75">Order insight</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Reorder speed matters</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                Your last 5 successful orders came from the Urban Motion and Executive Edit collections. Build a one-click reorder experience next.
              </p>
              <Button className="mt-6" tone="secondary" to="/app/collections">
                Open collections
              </Button>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
