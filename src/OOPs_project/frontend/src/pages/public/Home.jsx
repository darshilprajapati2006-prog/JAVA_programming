import { Link } from "react-router-dom";
import Button from "../../components/common/Button";
import CollectionCard from "../../components/cards/CollectionCard";
import ProductCard from "../../components/cards/ProductCard";
import { dummyData } from "../../constants/dummyData";

export default function Home() {
  return (
    <main className="page-shell">
      <div className="content-wrap space-y-8">
        <header className="surface-card sticky top-4 z-30 flex flex-col gap-4 p-5 md:flex-row md:items-center md:justify-between md:px-7">
          <div className="flex items-center gap-4">
            <div className="flex h-14 w-14 items-center justify-center rounded-2xl bg-ink-900 text-brand-200 shadow-[0_20px_36px_rgba(17,17,17,0.18)]">
              <svg className="h-7 w-7" fill="none" stroke="currentColor" strokeWidth="1.8" viewBox="0 0 24 24">
                <path d="M4 7h16l-1.5 11h-13z" />
                <path d="M9 7a3 3 0 0 1 6 0" />
              </svg>
            </div>
            <div>
              <p className="text-3xl font-semibold tracking-tight text-ink-900">Velora</p>
              <p className="mt-1 text-sm text-ink-400">Premium Commerce</p>
            </div>
          </div>

          <nav className="flex flex-wrap items-center gap-3 text-sm font-medium text-ink-500">
            <Link className="rounded-full px-4 py-2 transition hover:bg-ink-50 hover:text-ink-900" to="/shop">
              Shop
            </Link>
            <Link className="rounded-full px-4 py-2 transition hover:bg-ink-50 hover:text-ink-900" to="/login">
              Sign in
            </Link>
            <Button to="/register">Create account</Button>
          </nav>
        </header>

        <section className="grid gap-6 xl:grid-cols-[1.08fr_0.92fr]">
          <article className="rounded-[2.75rem] bg-gradient-to-br from-ink-900 via-[#1a1713] to-brand-700 p-8 text-white shadow-[0_32px_90px_rgba(17,17,17,0.24)] md:p-12">
            <span className="inline-flex rounded-full border border-white/10 bg-white/8 px-4 py-2 text-xs font-semibold uppercase tracking-[0.2em] text-brand-100">
              Curated Commerce
            </span>
            <h1 className="mt-6 max-w-3xl text-5xl font-semibold leading-tight tracking-tight md:text-7xl">
              A premium e-commerce experience built to convert cleanly
            </h1>
            <p className="mt-6 max-w-2xl text-base leading-8 text-white/82">
              Velora combines editorial product discovery, a full premium account dashboard, and a friction-light purchase flow designed for modern full-stack commerce products.
            </p>

            <div className="mt-8 flex flex-wrap gap-3">
              <Button className="bg-brand-400 text-ink-900 hover:bg-brand-300" to="/shop">
                Explore catalog
              </Button>
              <Button className="border border-white/18 text-white hover:bg-white/10" tone="ghost" to="/login">
                Open account
              </Button>
            </div>

            <div className="mt-10 grid gap-4 sm:grid-cols-2 xl:grid-cols-4">
              {dummyData.homeMetrics.map((item) => (
                <div key={item.label} className="rounded-[1.75rem] border border-white/10 bg-white/8 p-5 backdrop-blur-sm">
                  <p className="text-3xl font-semibold text-white">{item.value}</p>
                  <p className="mt-2 text-sm text-white/72">{item.label}</p>
                </div>
              ))}
            </div>
          </article>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Why this storefront feels different</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Premium by structure, not by decoration</h2>
              <div className="mt-8 space-y-4">
                {dummyData.homeHighlights.map((item, index) => (
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

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-brand-700 p-7 text-white shadow-[0_24px_60px_rgba(150,109,66,0.26)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Live app system</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Dashboard, wallet, orders, and checkout already connected</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                This frontend already includes the full signed-in commerce journey, so the landing page now acts as the premium public entry point.
              </p>
              <Button className="mt-6" tone="secondary" to="/app/dashboard">
                Open dashboard
              </Button>
            </article>
          </div>
        </section>

        <section className="space-y-6">
          <div className="flex items-end justify-between gap-4">
            <div>
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Featured collections</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Collections that drive discovery</h2>
            </div>
            <Button tone="secondary" to="/app/collections">
              View all collections
            </Button>
          </div>

          <div className="grid gap-6 lg:grid-cols-3">
            {dummyData.collectionHighlights.map((collection) => (
              <CollectionCard key={collection.title} collection={collection} />
            ))}
          </div>
        </section>

        <section className="space-y-6">
          <div className="flex items-end justify-between gap-4">
            <div>
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Top products</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Lead items from the premium catalog</h2>
            </div>
            <Button tone="secondary" to="/shop">
              Browse full shop
            </Button>
          </div>

          <div className="grid gap-6 md:grid-cols-2 xl:grid-cols-3">
            {dummyData.productCatalog.slice(0, 3).map((product) => (
              <ProductCard key={product.slug} product={product} />
            ))}
          </div>
        </section>

        <section className="surface-card grid gap-6 p-7 md:p-8 xl:grid-cols-[1fr_auto] xl:items-center">
          <div>
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Ready to continue</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Explore the complete premium commerce frontend</h2>
            <p className="mt-3 max-w-2xl text-sm leading-7 text-ink-500">
              From public discovery to signed-in order management, this system is now structured like a serious full-stack storefront frontend.
            </p>
          </div>
          <div className="flex flex-wrap gap-3">
            <Button to="/register">Create account</Button>
            <Button tone="secondary" to="/shop">
              Start shopping
            </Button>
          </div>
        </section>
      </div>
    </main>
  );
}
