import { useState } from "react";
import ProductCard from "../../components/cards/ProductCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";
import formatCurrency from "../../utils/formatCurrency";

export default function Shop() {
  const [activeFilter, setActiveFilter] = useState("All");

  const visibleProducts =
    activeFilter === "All"
      ? dummyData.productCatalog
      : activeFilter === "New"
        ? dummyData.productCatalog.filter((product) => product.tag === "New")
        : dummyData.productCatalog.filter((product) => product.category === activeFilter);

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/app/collections">Open collections</Button>}
          eyebrow="Catalog"
          title="Browse a premium, conversion-ready catalog"
          description="This is the main browsing surface for high-intent shopping: clean filters, elevated product cards, and merchandising sections that feel curated instead of crowded."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.catalogHighlights.map((item) => (
            <article
              key={item.label}
              className={`rounded-[2rem] bg-gradient-to-br p-6 shadow-[var(--shadow-soft-md)] ${
                item.tone === "primary"
                  ? "from-ink-900 to-[#27211b] text-brand-100"
                  : item.tone === "accent"
                    ? "from-brand-300 to-brand-100 text-ink-900"
                    : "from-white to-brand-50 text-ink-900"
              }`}
            >
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-current/80">{item.label}</p>
              <h2 className="mt-5 text-4xl font-semibold text-current">{item.value}</h2>
              <p className="mt-3 text-sm leading-6 text-current/80">{item.note}</p>
            </article>
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <article className="rounded-[2.25rem] bg-gradient-to-br from-ink-900 via-[#1b1712] to-brand-700 p-8 text-white shadow-[0_28px_80px_rgba(17,17,17,0.2)] md:p-10">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-100/80">Catalog spotlight</p>
            <h2 className="mt-5 max-w-xl text-4xl font-semibold leading-tight md:text-5xl">
              Discovery should feel curated, tactile, and quietly luxurious
            </h2>
            <p className="mt-5 max-w-2xl text-base leading-8 text-white/80">
              This catalog leans into editorial hierarchy, warm neutral contrast, and deliberate spacing so users move through products with more confidence and less visual fatigue.
            </p>
            <div className="mt-8 flex flex-wrap gap-3">
              <Button className="bg-brand-400 text-ink-900 hover:bg-brand-300" to="/products/velora-signature-backpack">
                View lead product
              </Button>
              <Button className="border border-white/20 text-white hover:bg-white/10" tone="ghost" to="/app/collections">
                Open collections
              </Button>
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-700">Price anchor</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Lead product for first-purchase trust</h2>
            <div className="mt-8 rounded-[1.75rem] border border-brand-100 bg-brand-50/55 p-6">
              <p className="text-xs font-semibold uppercase tracking-[0.18em] text-brand-700">Best seller</p>
              <h3 className="mt-3 text-2xl font-semibold text-ink-900">Velora Signature Backpack</h3>
              <p className="mt-3 text-sm leading-7 text-ink-500">
                The strongest trust anchor in the storefront. Strong enough for hero placement, recommendations, and quick-buy conversion.
              </p>
              <div className="mt-6 flex items-center justify-between gap-4">
                <p className="text-3xl font-semibold text-ink-900">{formatCurrency(4999)}</p>
                <span className="rounded-full bg-brand-100 px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-brand-700">
                  23% off
                </span>
              </div>
            </div>
            <div className="mt-6 flex gap-3">
              <Button className="flex-1" to="/products/velora-signature-backpack">
                View product
              </Button>
              <Button className="flex-1" tone="secondary">
                Add to cart
              </Button>
            </div>
          </article>
        </section>

        <section className="surface-card p-6 md:p-8">
          <div className="flex flex-col gap-5 lg:flex-row lg:items-center lg:justify-between">
            <div>
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-700">Browse controls</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Filter without flattening the luxury tone</h2>
            </div>
            <div className="flex flex-wrap gap-3">
              {dummyData.shopFilters.map((filter) => {
                const isActive = filter === activeFilter;

                return (
                  <button
                    key={filter}
                    className={`rounded-full px-5 py-3 text-sm font-semibold transition ${
                      isActive
                        ? "bg-ink-900 text-brand-100 shadow-[var(--shadow-soft-md)]"
                        : "bg-white text-ink-500 ring-1 ring-inset ring-brand-100 hover:bg-brand-50 hover:text-ink-900"
                    }`}
                    onClick={() => setActiveFilter(filter)}
                    type="button"
                  >
                    {filter}
                  </button>
                );
              })}
            </div>
          </div>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <div className="grid gap-6 md:grid-cols-2">
            {visibleProducts.map((product) => (
              <ProductCard key={product.slug} product={product} />
            ))}
          </div>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-700">Merchandising logic</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Why this catalog feels more premium</h2>
              <div className="mt-8 space-y-4">
                {dummyData.merchandisingNotes.map((item, index) => (
                  <div key={item.title} className="flex gap-4 rounded-[1.5rem] bg-brand-50/45 p-5">
                    <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-700 shadow-[var(--shadow-soft-md)]">
                      0{index + 1}
                    </div>
                    <div>
                      <p className="text-lg font-semibold text-ink-900">{item.title}</p>
                      <p className="mt-2 text-sm leading-7 text-ink-500">{item.copy}</p>
                    </div>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-brand-700 p-7 text-white shadow-[0_24px_60px_rgba(150,109,66,0.28)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Next move</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Push users into richer product intent</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                Once the catalog feels elevated, the detail page has to continue that tone through material cues, trust markers, and clearer purchase confidence.
              </p>
              <Button className="mt-6" tone="secondary" to="/products/velora-signature-backpack">
                Open product details
              </Button>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
