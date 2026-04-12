const toneClasses = {
  primary: "from-brand-500 to-brand-300 text-white",
  success: "from-emerald-500 to-emerald-300 text-white",
  accent: "from-amber-400 to-orange-300 text-ink-900",
  dark: "from-ink-900 to-ink-700 text-white",
};

export default function StatCard({ title, value, change, description, tone = "primary" }) {
  return (
    <article
      className={`rounded-[1.75rem] bg-gradient-to-br p-6 shadow-[var(--shadow-soft-md)] ${toneClasses[tone] ?? toneClasses.primary}`}
    >
      <p className="text-sm font-medium text-current/80">{title}</p>
      <div className="mt-6 flex items-end justify-between gap-4">
        <div>
          <h3 className="text-3xl font-semibold text-current">{value}</h3>
          <p className="mt-2 text-sm leading-6 text-current/80">{description}</p>
        </div>
        <span className="rounded-full bg-white/20 px-3 py-1 text-xs font-semibold uppercase tracking-[0.18em] text-current">
          {change}
        </span>
      </div>
    </article>
  );
}
