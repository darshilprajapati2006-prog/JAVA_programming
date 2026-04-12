export default function NotificationCard({ item }) {
  return (
    <article
      className={`rounded-[1.75rem] border p-5 shadow-[var(--shadow-soft-md)] ${
        item.unread ? "border-brand-200 bg-brand-50/70" : "border-ink-100 bg-white"
      }`}
    >
      <div className="flex items-start justify-between gap-4">
        <div>
          <div className="flex items-center gap-3">
            <span
              className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${
                item.type === "Order"
                  ? "bg-sky-50 text-sky-600"
                  : item.type === "Offer"
                    ? "bg-emerald-50 text-emerald-600"
                    : "bg-amber-50 text-amber-600"
              }`}
            >
              {item.type}
            </span>
            {item.unread ? <span className="h-2.5 w-2.5 rounded-full bg-brand-500" /> : null}
          </div>
          <h3 className="mt-4 text-xl font-semibold text-ink-900">{item.title}</h3>
          <p className="mt-3 text-sm leading-7 text-ink-500">{item.copy}</p>
        </div>
        <span className="shrink-0 text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">{item.time}</span>
      </div>
    </article>
  );
}
