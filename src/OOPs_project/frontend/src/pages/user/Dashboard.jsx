import StatCard from "../../components/cards/StatCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Dashboard() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/shop">Explore New Arrivals</Button>}
          description="Track spending, manage orders, and discover premium curated drops from one clean command center."
          eyebrow="Overview"
          title="Your commerce dashboard"
        />

        <section className="grid gap-5 xl:grid-cols-4 md:grid-cols-2">
          {dummyData.dashboardStats.map((stat) => (
            <StatCard key={stat.title} {...stat} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.45fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-start justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Quick actions</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Move faster across your buying flow</h2>
              </div>
              <div className="hidden rounded-full bg-brand-50 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-brand-600 md:block">
                Smooth workflow
              </div>
            </div>
            <div className="mt-8 grid gap-4 md:grid-cols-3">
              {dummyData.quickActions.map((action, index) => (
                <article
                  key={action.title}
                  className={`rounded-[1.75rem] p-6 ${
                    index === 1 ? "bg-ink-900 text-white" : "bg-ink-50 text-ink-900"
                  }`}
                >
                  <p className={`text-sm font-semibold ${index === 1 ? "text-white/70" : "text-brand-600"}`}>{action.title}</p>
                  <p className={`mt-4 text-sm leading-6 ${index === 1 ? "text-white/72" : "text-ink-500"}`}>{action.copy}</p>
                  <Button className="mt-6" tone={index === 1 ? "secondary" : "primary"}>
                    {action.cta}
                  </Button>
                </article>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Notifications</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Live activity</h2>
            <div className="mt-8 space-y-4">
              {dummyData.notifications.map((item) => (
                <div key={item.title} className="rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex items-start justify-between gap-4">
                    <div>
                      <p className="text-base font-semibold text-ink-900">{item.title}</p>
                      <p className="mt-2 text-sm leading-6 text-ink-500">{item.copy}</p>
                    </div>
                    <span className="shrink-0 text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">
                      {item.time}
                    </span>
                  </div>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.1fr_0.9fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Recent orders</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Orders that still need your attention</h2>
              </div>
              <Button tone="secondary" to="/app/orders">
                View all
              </Button>
            </div>
            <div className="mt-8 space-y-4">
              {dummyData.recentOrders.map((order) => (
                <article key={order.id} className="rounded-[1.75rem] border border-ink-100 bg-white p-5 shadow-[var(--shadow-soft-md)]">
                  <div className="flex flex-wrap items-start justify-between gap-4">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">{order.id}</p>
                      <h3 className="mt-2 text-xl font-semibold text-ink-900">{order.item}</h3>
                    </div>
                    <span className="rounded-full bg-emerald-50 px-3 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-emerald-600">
                      {order.status}
                    </span>
                  </div>
                  <div className="mt-6 grid gap-4 border-t border-ink-100 pt-4 text-sm text-ink-500 md:grid-cols-3">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">Date</p>
                      <p className="mt-2 text-base font-medium text-ink-800">{order.date}</p>
                    </div>
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">Amount</p>
                      <p className="mt-2 text-base font-medium text-ink-800">{order.amount}</p>
                    </div>
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-ink-300">Next step</p>
                      <p className="mt-2 text-base font-medium text-ink-800">Track shipment</p>
                    </div>
                  </div>
                </article>
              ))}
            </div>
          </article>

          <article className="surface-card overflow-hidden p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Featured collections</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Build a sharper cart</h2>
            <div className="mt-8 space-y-4">
              {dummyData.featuredCollections.map((collection) => (
                <article
                  key={collection.title}
                  className={`rounded-[1.75rem] bg-gradient-to-br ${collection.accent} p-6 text-white shadow-[var(--shadow-soft-md)]`}
                >
                  <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/70">{collection.itemCount}</p>
                  <h3 className="mt-4 text-2xl font-semibold text-white">{collection.title}</h3>
                  <p className="mt-2 text-sm leading-6 text-white/80">{collection.subtitle}</p>
                  <Button className="mt-6" tone="secondary" to="/app/collections">
                    Open collection
                  </Button>
                </article>
              ))}
            </div>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
