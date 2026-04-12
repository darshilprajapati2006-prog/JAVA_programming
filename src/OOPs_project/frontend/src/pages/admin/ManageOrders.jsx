import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

function QueueBadge({ status }) {
  const tone =
    status === "Priority"
      ? "bg-rose-50 text-rose-600"
      : status === "Refund Pending"
        ? "bg-amber-50 text-amber-600"
        : "bg-sky-50 text-sky-600";

  return <span className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${tone}`}>{status}</span>;
}

export default function ManageOrders() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin/users">Open user management</Button>}
          eyebrow="Admin Orders"
          title="Resolve fulfillment issues before they affect trust"
          description="This module prioritizes exception handling, refund review, and operational clarity for high-risk orders."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.adminOrderSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Exception queue</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Orders requiring admin intervention</h2>
            <div className="mt-8 space-y-4">
              {dummyData.adminOrderQueue.map((item) => (
                <article key={item.id} className="rounded-[1.75rem] bg-ink-50 p-5">
                  <div className="flex flex-col gap-4 lg:flex-row lg:items-center lg:justify-between">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">{item.orderId}</p>
                      <h3 className="mt-2 text-2xl font-semibold text-ink-900">{item.customer}</h3>
                      <p className="mt-2 text-sm text-ink-500">{item.issue}</p>
                    </div>
                    <div className="flex flex-wrap items-center gap-3">
                      <p className="text-base font-semibold text-ink-900">{item.amount}</p>
                      <QueueBadge status={item.status} />
                      <Button tone="secondary">Review</Button>
                    </div>
                  </div>
                </article>
              ))}
            </div>
          </article>

          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Ops note</p>
            <h2 className="mt-3 text-3xl font-semibold text-white">Order operations are the trust center</h2>
            <p className="mt-4 text-sm leading-7 text-white/82">
              Slow or unclear exception handling damages repeat conversion faster than almost any other admin failure point.
            </p>
            <Button className="mt-6" tone="secondary" to="/admin/analytics">
              Open analytics
            </Button>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
