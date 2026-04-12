import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

function StatusBadge({ children, tone }) {
  const tones = {
    published: "bg-emerald-50 text-emerald-600",
    draft: "bg-amber-50 text-amber-600",
    healthy: "bg-sky-50 text-sky-600",
    low: "bg-rose-50 text-rose-600",
    review: "bg-violet-50 text-violet-600",
  };

  return (
    <span className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${tones[tone]}`}>
      {children}
    </span>
  );
}

export default function ManageProducts() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin">Back to admin overview</Button>}
          eyebrow="Admin Products"
          title="Control what goes live in the storefront"
          description="This module focuses on listing health, inventory visibility, and product readiness before items reach the customer-facing catalog."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.adminProductSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Catalog table</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Products requiring admin oversight</h2>
              </div>
              <Button>Add product</Button>
            </div>

            <div className="mt-8 space-y-4">
              {dummyData.adminProducts.map((product) => (
                <article key={product.id} className="rounded-[1.75rem] border border-ink-100 bg-ink-50 p-5">
                  <div className="flex flex-col gap-5 xl:flex-row xl:items-center xl:justify-between">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">{product.category}</p>
                      <h3 className="mt-2 text-2xl font-semibold text-ink-900">{product.title}</h3>
                      <p className="mt-3 text-sm text-ink-500">Last updated {product.updatedAt}</p>
                    </div>

                    <div className="grid gap-4 sm:grid-cols-2 xl:grid-cols-4 xl:items-center">
                      <div>
                        <p className="text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">Price</p>
                        <p className="mt-2 text-base font-semibold text-ink-900">{product.price}</p>
                      </div>
                      <div>
                        <p className="text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">Stock</p>
                        <p className="mt-2 text-base font-semibold text-ink-900">{product.stock}</p>
                      </div>
                      <div className="flex flex-wrap gap-2">
                        <StatusBadge tone={product.state === "Published" ? "published" : "draft"}>{product.state}</StatusBadge>
                        <StatusBadge
                          tone={
                            product.inventory === "Healthy"
                              ? "healthy"
                              : product.inventory === "Low Stock"
                                ? "low"
                                : "review"
                          }
                        >
                          {product.inventory}
                        </StatusBadge>
                      </div>
                      <div className="flex gap-3">
                        <Button tone="secondary">Edit</Button>
                        <Button>Review</Button>
                      </div>
                    </div>
                  </div>
                </article>
              ))}
            </div>
          </article>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Admin actions</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">High-value catalog tasks</h2>
              <div className="mt-8 space-y-4">
                {dummyData.adminProductActions.map((item, index) => (
                  <div key={item} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                    <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
                      0{index + 1}
                    </div>
                    <p className="text-sm leading-7 text-ink-600">{item}</p>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Next admin module</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Orders should come next</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                Once catalog control is visible, the next strongest admin workflow is operational order management with fulfillment and exception handling.
              </p>
              <Button className="mt-6" tone="secondary" to="/admin/orders">
                Open order operations
              </Button>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
