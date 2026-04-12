import { Link } from "react-router-dom";
import Button from "../common/Button";
import formatCurrency from "../../utils/formatCurrency";

export default function ProductCard({ product }) {
  const discount = Math.round(((product.originalPrice - product.price) / product.originalPrice) * 100);

  return (
    <article
      className={`rounded-[2rem] border border-white/70 bg-gradient-to-br ${product.accent} p-6 shadow-[var(--shadow-soft-lg)] transition duration-300 hover:-translate-y-1 hover:shadow-[var(--shadow-soft-xl)]`}
    >
      <div className="flex items-start justify-between gap-4">
        <span className="rounded-full bg-white px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-brand-700 shadow-[var(--shadow-soft-md)]">
          {product.tag}
        </span>
        <button
          className="inline-flex h-11 w-11 items-center justify-center rounded-2xl bg-white text-ink-500 shadow-[var(--shadow-soft-md)] transition hover:bg-brand-50 hover:text-brand-700"
          type="button"
        >
          <svg className="h-5 w-5" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
            <path d="m12 20-6.2-6.2a4.4 4.4 0 1 1 6.2-6.2 4.4 4.4 0 1 1 6.2 6.2Z" />
          </svg>
        </button>
      </div>

      <div className="mt-8 flex h-44 items-center justify-center rounded-[1.75rem] border border-white/60 bg-white/72 shadow-[inset_0_1px_0_rgba(255,255,255,0.8)]">
        <div className="flex h-24 w-24 items-center justify-center rounded-[2rem] bg-gradient-to-br from-ink-900 to-brand-500 text-brand-100 shadow-[var(--shadow-soft-lg)]">
          <svg className="h-10 w-10" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
            <path d="M4 7h16l-1.5 11h-13z" />
            <path d="M9 7a3 3 0 0 1 6 0" />
          </svg>
        </div>
      </div>

      <div className="mt-6">
        <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-400">{product.category}</p>
        <Link className="mt-3 block text-2xl font-semibold text-ink-900" to={`/products/${product.slug}`}>
          {product.title}
        </Link>
        <p className="mt-3 text-sm leading-7 text-ink-500">{product.description}</p>
      </div>

      <div className="mt-6 flex items-end justify-between gap-4">
        <div>
          <p className="text-2xl font-semibold text-ink-900">{formatCurrency(product.price)}</p>
          <p className="mt-1 text-sm text-ink-400 line-through">{formatCurrency(product.originalPrice)}</p>
        </div>
        <span className="rounded-full bg-brand-50 px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-brand-700">
          {discount}% off
        </span>
      </div>

      <div className="mt-6 flex gap-3">
        <Button className="flex-1" to={`/products/${product.slug}`}>
          View product
        </Button>
        <Button className="flex-1" tone="secondary">
          Add to cart
        </Button>
      </div>
    </article>
  );
}
