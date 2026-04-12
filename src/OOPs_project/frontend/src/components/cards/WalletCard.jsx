export default function WalletCard({ title, value, note, tone = "primary" }) {
  const toneClasses = {
    primary: "from-brand-500 to-brand-300 text-white",
    success: "from-emerald-500 to-emerald-300 text-white",
    accent: "from-amber-400 to-orange-300 text-ink-900",
    dark: "from-ink-900 to-ink-700 text-white",
  };

  return (
    <article
      className={`rounded-[2rem] bg-gradient-to-br p-6 shadow-[var(--shadow-soft-lg)] ${toneClasses[tone] ?? toneClasses.primary}`}
    >
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-current/78">{title}</p>
      <h2 className="mt-5 text-4xl font-semibold text-current">{value}</h2>
      <p className="mt-3 text-sm leading-6 text-current/80">{note}</p>
    </article>
  );
}
