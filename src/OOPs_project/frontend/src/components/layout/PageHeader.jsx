export default function PageHeader({ eyebrow, title, description, action }) {
  return (
    <header className="flex flex-col gap-6 lg:flex-row lg:items-end lg:justify-between">
      <div>
        {eyebrow ? (
          <span className="inline-flex rounded-full bg-white px-4 py-2 text-xs font-semibold uppercase tracking-[0.2em] text-brand-600 shadow-[var(--shadow-soft-md)]">
            {eyebrow}
          </span>
        ) : null}
        <h1 className="mt-4 text-4xl font-semibold tracking-tight text-ink-900 md:text-5xl">{title}</h1>
        {description ? <p className="mt-3 max-w-2xl text-lg text-ink-500">{description}</p> : null}
      </div>
      {action ? <div className="shrink-0">{action}</div> : null}
    </header>
  );
}
