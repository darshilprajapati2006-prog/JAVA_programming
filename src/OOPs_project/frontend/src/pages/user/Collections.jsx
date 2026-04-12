import AppShell from "../../components/layout/AppShell";
import CollectionCard from "../../components/cards/CollectionCard";
import Button from "../../components/common/Button";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";
import formatCurrency from "../../utils/formatCurrency";

export default function Collections() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/shop">Open full catalog</Button>}
          eyebrow="Collections"
          title="Curated collections built for premium discovery"
          description="Explore polished edits, category-led browsing, and high-intent product groupings designed to move users deeper into the shop flow."
        />

        <section className="grid gap-6 xl:grid-cols-[1.25fr_0.75fr]">
          <article className="rounded-[2.25rem] bg-gradient-to-br from-ink-900 via-brand-900 to-brand-500 p-8 text-white shadow-[0_24px_70px_rgba(15,23,42,0.25)] md:p-10">
            <p className="text-sm font-semibold uppercase tracking-[0.2em] text-white/70">Featured edit</p>
            <h2 className="mt-5 max-w-xl text-4xl font-semibold leading-tight md:text-5xl">
              One premium storefront, multiple buying moods
            </h2>
            <p className="mt-5 max-w-2xl text-base leading-8 text-white/78">
              Instead of dumping products in a flat grid, this section groups inventory by intent: commute, work, travel, and gifting. It makes discovery feel premium and easier to shop.
            </p>
            <div className="mt-8 flex flex-wrap gap-3">
              <Button className="bg-white text-ink-900 hover:bg-white/90" to="/shop">
                Start shopping
              </Button>
              <Button className="border border-white/20 text-white hover:bg-white/10" tone="ghost" to="/app/orders">
                Review last orders
              </Button>
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Browse by category</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Fast entry points</h2>
            <div className="mt-8 space-y-4">
              {dummyData.collectionCategories.map((category) => (
                <div key={category.label} className="rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex items-start justify-between gap-4">
                    <div>
                      <p className="text-lg font-semibold text-ink-900">{category.label}</p>
                      <p className="mt-2 text-sm leading-6 text-ink-500">{category.note}</p>
                    </div>
                    <span className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${category.accent}`}>
                      {category.itemCount}
                    </span>
                  </div>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 lg:grid-cols-3">
          {dummyData.collectionHighlights.map((collection) => (
            <CollectionCard key={collection.title} collection={collection} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.05fr_0.95fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Curated drops</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Products pushing the strongest demand</h2>
              </div>
              <Button tone="secondary" to="/shop">
                Browse all
              </Button>
            </div>

            <div className="mt-8 grid gap-4">
              {dummyData.curatedDrops.map((drop) => (
                <article
                  key={drop.title}
                  className={`rounded-[1.75rem] border border-white/70 bg-gradient-to-br ${drop.accent} p-6 shadow-[var(--shadow-soft-md)]`}
                >
                  <div className="flex flex-wrap items-start justify-between gap-4">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-brand-600">{drop.tag}</p>
                      <h3 className="mt-3 text-2xl font-semibold text-ink-900">{drop.title}</h3>
                      <p className="mt-3 max-w-md text-sm leading-7 text-ink-500">{drop.note}</p>
                    </div>
                    <p className="text-2xl font-semibold text-ink-900">{formatCurrency(drop.price)}</p>
                  </div>
                </article>
              ))}
            </div>
          </article>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Seasonal directions</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Merchandising stories</h2>
              <div className="mt-8 space-y-4">
                {dummyData.seasonalCollections.map((item, index) => (
                  <div key={item.title} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                    <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
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

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Conversion tip</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Collection-led shopping converts better</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                Users buy faster when products are framed around use-cases. This page becomes the discovery bridge between dashboard trust and product purchase intent.
              </p>
              <Button className="mt-6" tone="secondary" to="/shop">
                Continue to shop
              </Button>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
