const defaultData = [
  { label: "Wallet", value: 24, tone: "bg-brand-500" },
  { label: "Card", value: 46, tone: "bg-ink-900" },
  { label: "UPI", value: 30, tone: "bg-emerald-500" },
];

export default function SpendingChart({ data = defaultData, title = "Spending mix" }) {
  return (
    <article className="surface-card p-6 md:p-7">
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">{title}</p>
      <div className="mt-8 overflow-hidden rounded-full bg-ink-100">
        <div className="flex h-5 w-full">
          {data.map((item) => (
            <div key={item.label} className={item.tone} style={{ width: `${item.value}%` }} />
          ))}
        </div>
      </div>
      <div className="mt-6 space-y-3">
        {data.map((item) => (
          <div key={item.label} className="flex items-center justify-between gap-4">
            <div className="flex items-center gap-3">
              <span className={`h-3 w-3 rounded-full ${item.tone}`} />
              <span className="text-sm font-medium text-ink-700">{item.label}</span>
            </div>
            <span className="text-sm font-semibold text-ink-900">{item.value}%</span>
          </div>
        ))}
      </div>
    </article>
  );
}
