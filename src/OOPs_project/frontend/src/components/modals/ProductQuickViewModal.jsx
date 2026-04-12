import Button from "../common/Button";
import formatCurrency from "../../utils/formatCurrency";

export default function ProductQuickViewModal({ open, product, onClose }) {
  if (!open || !product) {
    return null;
  }

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-ink-900/45 px-4">
      <div className="w-full max-w-4xl rounded-[2rem] bg-white p-7 shadow-[0_30px_80px_rgba(15,23,42,0.25)] md:p-8">
        <div className="grid gap-6 md:grid-cols-[0.85fr_1.15fr]">
          <div className={`rounded-[2rem] bg-gradient-to-br ${product.accent} p-6`}>
            <div className="flex h-full min-h-[260px] items-center justify-center rounded-[1.75rem] bg-white/70">
              <div className="flex h-28 w-28 items-center justify-center rounded-[2rem] bg-gradient-to-br from-ink-900 to-brand-500 text-white shadow-[var(--shadow-soft-lg)]">
                <svg className="h-12 w-12" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
                  <path d="M4 7h16l-1.5 11h-13z" />
                  <path d="M9 7a3 3 0 0 1 6 0" />
                </svg>
              </div>
            </div>
          </div>

          <div>
            <div className="flex items-start justify-between gap-4">
              <div>
                <p className="text-xs font-semibold uppercase tracking-[0.18em] text-brand-600">{product.tag}</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">{product.title}</h2>
                <p className="mt-3 text-sm leading-7 text-ink-500">{product.description}</p>
              </div>
              <button className="text-sm font-semibold text-ink-400 transition hover:text-ink-900" onClick={onClose} type="button">
                Close
              </button>
            </div>

            <div className="mt-8 flex items-end gap-4">
              <p className="text-3xl font-semibold text-ink-900">{formatCurrency(product.price)}</p>
              <p className="text-base text-ink-300 line-through">{formatCurrency(product.originalPrice)}</p>
            </div>

            <div className="mt-8 flex flex-col gap-3 sm:flex-row">
              <Button className="flex-1">Add to cart</Button>
              <Button className="flex-1" onClick={onClose} tone="secondary">
                Keep browsing
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
