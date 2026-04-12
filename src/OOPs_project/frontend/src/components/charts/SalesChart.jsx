const defaultData = [
  { label: "Mon", value: 42 },
  { label: "Tue", value: 56 },
  { label: "Wed", value: 38 },
  { label: "Thu", value: 74 },
  { label: "Fri", value: 68 },
  { label: "Sat", value: 88 },
];

export default function SalesChart({ data = defaultData, title = "Sales trend" }) {
  const maxValue = Math.max(...data.map((item) => item.value), 1);

  return (
    <article className="surface-card p-6 md:p-7">
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">{title}</p>
      <div className="mt-8 flex h-56 items-end gap-3">
        {data.map((item) => (
          <div key={item.label} className="flex flex-1 flex-col items-center gap-3">
            <div className="flex h-44 w-full items-end rounded-[1.5rem] bg-ink-50 p-2">
              <div
                className="w-full rounded-[1rem] bg-gradient-to-t from-brand-500 to-brand-300"
                style={{ height: `${(item.value / maxValue) * 100}%` }}
              />
            </div>
            <div className="text-center">
              <p className="text-sm font-semibold text-ink-800">{item.value}</p>
              <p className="mt-1 text-xs uppercase tracking-[0.16em] text-ink-300">{item.label}</p>
            </div>
          </div>
        ))}
      </div>
    </article>
  );
}
