import Badge from "../common/Badge";
import Button from "../common/Button";
import { statusColors } from "../../constants/statusColors";
import formatCurrency from "../../utils/formatCurrency";

function Detail({ label, value }) {
  return (
    <div>
      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">{label}</p>
      <p className="mt-2 text-base font-medium text-ink-800">{value}</p>
    </div>
  );
}

export default function OrderCard({ order }) {
  const status = statusColors[order.status] ?? statusColors.Processing;

  return (
    <article
      className={`rounded-[2rem] border border-white/70 bg-gradient-to-br ${order.accent} p-6 shadow-[var(--shadow-soft-lg)] md:p-7`}
    >
      <div className="flex flex-wrap items-start justify-between gap-4">
        <div className="flex items-start gap-4">
          <div className="flex h-16 w-16 items-center justify-center rounded-[1.5rem] bg-white text-brand-500 shadow-[var(--shadow-soft-md)]">
            <svg className="h-8 w-8" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
              <path d="M4 7h16l-1.5 11h-13z" />
              <path d="M9 7a3 3 0 0 1 6 0" />
            </svg>
          </div>
          <div>
            <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">{order.id}</p>
            <h3 className="mt-2 text-2xl font-semibold text-ink-900">{order.item}</h3>
            <p className="mt-2 text-sm text-ink-500">{order.category}</p>
          </div>
        </div>
        <Badge className={status.badge}>{order.status}</Badge>
      </div>

      <div className="mt-6 grid gap-5 border-t border-ink-100 pt-5 md:grid-cols-4">
        <Detail label="Order date" value={order.date} />
        <Detail label="Estimated status" value={order.eta} />
        <Detail label="Payment" value={order.payment} />
        <Detail label="Quantity" value={`${order.quantity} item${order.quantity > 1 ? "s" : ""}`} />
      </div>

      <div className="mt-6 flex flex-wrap items-center justify-between gap-4 border-t border-ink-100 pt-5">
        <div className="flex flex-wrap items-center gap-4 text-sm text-ink-500">
          <div className="flex items-center gap-2">
            <span className={`h-2.5 w-2.5 rounded-full ${status.dot}`} />
            <span>From {order.from}</span>
          </div>
          <span className="text-ink-300" aria-hidden="true">
            {"->"}
          </span>
          <span>To {order.to}</span>
        </div>

        <div className="flex flex-wrap items-center gap-3">
          <p className={`text-2xl font-semibold ${status.accent}`}>{formatCurrency(order.price)}</p>
          <Button tone="secondary">View details</Button>
          <Button>{order.status === "Delivered" ? "Buy again" : "Track order"}</Button>
        </div>
      </div>
    </article>
  );
}
