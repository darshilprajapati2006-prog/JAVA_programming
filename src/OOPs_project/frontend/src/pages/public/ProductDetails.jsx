import { useState } from "react";
import { useParams } from "react-router-dom";
import ProductCard from "../../components/cards/ProductCard";
import Button from "../../components/common/Button";
import EmptyState from "../../components/common/EmptyState";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";
import calculateDiscount from "../../utils/calculateDiscount";
import formatCurrency from "../../utils/formatCurrency";

export default function ProductDetails() {
  const { slug } = useParams();
  const product = dummyData.productDetailMap[slug];
  const [selectedGallery, setSelectedGallery] = useState(0);

  const relatedProducts = dummyData.relatedProducts.filter((item) => item.slug !== slug);

  if (!product) {
    return (
      <AppShell>
        <EmptyState
          ctaLabel="Back to shop"
          description="This product has not been mapped yet in the mock catalog. Continue to the shop and open one of the live products."
          title="Product not found"
        />
      </AppShell>
    );
  }

  const discount = calculateDiscount({
    currentPrice: product.price,
    originalPrice: product.originalPrice,
  });

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/shop">Back to catalog</Button>}
          eyebrow={product.category}
          title={product.title}
          description={product.shortDescription}
        />

        <section className="grid gap-6 xl:grid-cols-[1.05fr_0.95fr]">
          <article className="surface-card p-6 md:p-8">
            <div className="rounded-[2rem] bg-gradient-to-br from-ink-900 via-brand-900 to-brand-500 p-8 text-white shadow-[0_24px_70px_rgba(15,23,42,0.24)] md:p-10">
              <div className="flex flex-wrap items-start justify-between gap-4">
                <span className="rounded-full bg-white/12 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-white/80">
                  {product.tag}
                </span>
                <span className="rounded-full bg-white/12 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-white/80">
                  {product.rating} · {product.reviews}
                </span>
              </div>

              <div className="mt-10 flex min-h-[320px] items-center justify-center rounded-[2.25rem] bg-white/8 backdrop-blur-sm">
                <div className="flex h-40 w-40 items-center justify-center rounded-[2.5rem] bg-white text-ink-900 shadow-[0_25px_50px_rgba(255,255,255,0.18)]">
                  <svg className="h-20 w-20" fill="none" stroke="currentColor" strokeWidth="1.7" viewBox="0 0 24 24">
                    <path d="M4 7h16l-1.5 11h-13z" />
                    <path d="M9 7a3 3 0 0 1 6 0" />
                  </svg>
                </div>
              </div>
            </div>

            <div className="mt-5 grid gap-4 sm:grid-cols-2 xl:grid-cols-4">
              {product.gallery.map((item, index) => {
                const isActive = selectedGallery === index;

                return (
                  <button
                    key={item}
                    className={`rounded-[1.5rem] p-4 text-left transition ${
                      isActive
                        ? "bg-ink-900 text-white shadow-[var(--shadow-soft-md)]"
                        : "bg-ink-50 text-ink-500 hover:bg-white hover:text-ink-900"
                    }`}
                    onClick={() => setSelectedGallery(index)}
                    type="button"
                  >
                    <p className="text-sm font-semibold">{item}</p>
                    <p className={`mt-2 text-xs ${isActive ? "text-white/70" : "text-ink-300"}`}>
                      View {index + 1}
                    </p>
                  </button>
                );
              })}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <div className="flex flex-wrap items-center gap-3">
              <span className="rounded-full bg-brand-50 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-brand-600">
                {product.tag}
              </span>
              <span className="rounded-full bg-emerald-50 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-emerald-600">
                {discount}% off
              </span>
            </div>

            <div className="mt-6 flex flex-wrap items-end gap-4">
              <p className="text-5xl font-semibold tracking-tight text-ink-900">{formatCurrency(product.price)}</p>
              <p className="pb-1 text-xl text-ink-300 line-through">{formatCurrency(product.originalPrice)}</p>
            </div>

            <p className="mt-6 text-base leading-8 text-ink-500">{product.description}</p>

            <div className="mt-8 grid gap-4">
              <div className="rounded-[1.5rem] bg-ink-50 p-5">
                <p className="text-sm font-semibold text-ink-900">{product.delivery}</p>
                <p className="mt-2 text-sm leading-6 text-ink-500">{product.stock}</p>
              </div>
              <div className="rounded-[1.5rem] bg-brand-50 p-5">
                <p className="text-sm font-semibold text-brand-700">{product.points}</p>
                <p className="mt-2 text-sm leading-6 text-brand-600">
                  Reward points apply instantly to your next premium checkout.
                </p>
              </div>
            </div>

            <div className="mt-8 flex flex-col gap-3 sm:flex-row">
              <Button className="flex-1">Add to cart</Button>
              <Button className="flex-1" tone="secondary">
                Buy now
              </Button>
            </div>

            <div className="mt-8 border-t border-ink-100 pt-6">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Trust cues</p>
              <div className="mt-4 space-y-3">
                {product.trustNotes.map((note) => (
                  <div key={note} className="flex items-start gap-3 rounded-[1.25rem] bg-ink-50 p-4">
                    <span className="mt-1 h-2.5 w-2.5 rounded-full bg-brand-500" />
                    <p className="text-sm leading-6 text-ink-600">{note}</p>
                  </div>
                ))}
              </div>
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Feature stack</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Built around premium daily use</h2>
            <div className="mt-8 grid gap-4">
              {product.features.map((feature, index) => (
                <div key={feature} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
                    0{index + 1}
                  </div>
                  <p className="text-sm leading-7 text-ink-600">{feature}</p>
                </div>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Specifications</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Technical overview</h2>
            <div className="mt-8 divide-y divide-ink-100 overflow-hidden rounded-[1.75rem] border border-ink-100 bg-white">
              {product.specifications.map((spec) => (
                <div key={spec.label} className="flex items-center justify-between gap-4 px-5 py-4">
                  <p className="text-sm font-medium text-ink-500">{spec.label}</p>
                  <p className="text-sm font-semibold text-ink-900">{spec.value}</p>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="space-y-6">
          <div className="flex items-end justify-between gap-4">
            <div>
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Recommended next</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Products that pair well with this pick</h2>
            </div>
            <Button tone="secondary" to="/shop">
              Continue browsing
            </Button>
          </div>

          <div className="grid gap-6 md:grid-cols-2 xl:grid-cols-3">
            {relatedProducts.map((item) => (
              <ProductCard key={item.slug} product={item} />
            ))}
          </div>
        </section>
      </div>
    </AppShell>
  );
}
