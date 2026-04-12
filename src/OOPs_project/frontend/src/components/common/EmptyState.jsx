import Button from "./Button";

export default function EmptyState({
  title,
  description,
  ctaLabel,
  ctaTo = "/shop",
}) {
  return (
    <div className="surface-card p-10 text-center">
      <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-[1.5rem] bg-brand-50 text-brand-600 shadow-[var(--shadow-soft-md)]">
        <svg className="h-8 w-8" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
          <path d="M4 7h16l-1.5 11h-13z" />
          <path d="M9 7a3 3 0 0 1 6 0" />
        </svg>
      </div>
      <h2 className="mt-6 text-3xl font-semibold text-ink-900">{title}</h2>
      <p className="mx-auto mt-3 max-w-xl text-ink-500">{description}</p>
      {ctaLabel ? (
        <Button className="mt-6" to={ctaTo}>
          {ctaLabel}
        </Button>
      ) : null}
    </div>
  );
}
