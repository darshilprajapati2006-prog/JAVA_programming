import StatCard from "../../components/cards/StatCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function AdminDashboard() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin/analytics">Open analytics</Button>}
          eyebrow="Admin"
          title="Control the commerce system from one operations panel"
          description="This dashboard is focused on operational clarity: revenue movement, order issues, catalog health, and customer management pressure points."
        />

        <section className="grid gap-5 md:grid-cols-2 xl:grid-cols-4">
          {dummyData.adminStats.map((item) => (
            <StatCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.2fr_0.8fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-start justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Management queues</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">What needs action from the admin team</h2>
              </div>
              <div className="hidden rounded-full bg-brand-50 px-4 py-2 text-xs font-semibold uppercase tracking-[0.18em] text-brand-600 md:block">
                Ops priority
              </div>
            </div>

            <div className="mt-8 grid gap-4">
              {dummyData.adminQueues.map((item) => (
                <article key={item.title} className="rounded-[1.75rem] bg-ink-50 p-6">
                  <p className="text-xl font-semibold text-ink-900">{item.title}</p>
                  <p className="mt-3 text-sm leading-7 text-ink-500">{item.copy}</p>
                  <Button className="mt-6" to={item.to}>
                    {item.cta}
                  </Button>
                </article>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Recent admin activity</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Latest decisions and updates</h2>
            <div className="mt-8 space-y-4">
              {dummyData.adminRecentActivity.map((item, index) => (
                <div key={item.title} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
                    0{index + 1}
                  </div>
                  <div>
                    <p className="text-lg font-semibold text-ink-900">{item.title}</p>
                    <p className="mt-2 text-sm leading-7 text-ink-500">{item.copy}</p>
                    <p className="mt-3 text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">{item.time}</p>
                  </div>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Admin modules</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Jump directly into management areas</h2>
              </div>
            </div>

            <div className="mt-8 grid gap-4 sm:grid-cols-2">
              {dummyData.adminPanels.map((panel) => (
                <article key={panel.title} className="rounded-[1.5rem] bg-ink-50 p-5">
                  <p className="text-lg font-semibold text-ink-900">{panel.title}</p>
                  <p className="mt-2 text-sm leading-7 text-ink-500">{panel.note}</p>
                  <Button className="mt-5" tone="secondary" to={panel.to}>
                    Open module
                  </Button>
                </article>
              ))}
            </div>
          </article>

          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Admin system note</p>
            <h2 className="mt-3 text-3xl font-semibold text-white">This is the first admin milestone</h2>
            <p className="mt-4 text-sm leading-7 text-white/82">
              Dashboard visibility is now in place. The next step is implementing each management module one by one so the admin area becomes fully usable.
            </p>
            <Button className="mt-6" tone="secondary" to="/admin/products">
              Start with products
            </Button>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
