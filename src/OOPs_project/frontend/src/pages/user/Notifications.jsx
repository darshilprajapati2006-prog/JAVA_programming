import AppShell from "../../components/layout/AppShell";
import NotificationCard from "../../components/cards/NotificationCard";
import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Notifications() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/app/orders">Open orders</Button>}
          eyebrow="Notifications"
          title="Stay on top of orders, offers, and rewards"
          description="A premium notification center should separate urgency from noise. This page surfaces delivery-critical updates, active rewards, and campaign alerts without feeling cluttered."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.notificationSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.1fr_0.9fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Live feed</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">What needs attention right now</h2>
              </div>
              <button
                className="rounded-full bg-ink-900 px-5 py-3 text-sm font-semibold text-white shadow-[var(--shadow-soft-md)]"
                type="button"
              >
                Mark all read
              </button>
            </div>

            <div className="mt-8 space-y-4">
              {dummyData.notificationCenter.map((item) => (
                <NotificationCard key={item.id} item={item} />
              ))}
            </div>
          </article>

          <div className="space-y-6">
            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Promotion radar</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Campaigns worth acting on</h2>
              <div className="mt-8 space-y-4">
                {dummyData.notificationPromos.map((item, index) => (
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

            <article className="surface-card p-7 md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Notification preferences</p>
              <h2 className="mt-3 text-3xl font-semibold text-ink-900">Core channels enabled</h2>
              <div className="mt-8 space-y-4">
                {dummyData.notificationPreferences.map((item) => (
                  <div key={item} className="flex items-center justify-between rounded-[1.5rem] bg-ink-50 p-5">
                    <div>
                      <p className="text-base font-semibold text-ink-900">{item}</p>
                      <p className="mt-1 text-sm text-ink-500">Active for web and account-level updates</p>
                    </div>
                    <div className="flex h-8 w-14 items-center rounded-full bg-brand-500 px-1">
                      <span className="ml-auto h-6 w-6 rounded-full bg-white shadow" />
                    </div>
                  </div>
                ))}
              </div>
            </article>

            <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Design note</p>
              <h2 className="mt-3 text-3xl font-semibold text-white">Notifications should feel actionable</h2>
              <p className="mt-4 text-sm leading-7 text-white/82">
                This page is less about unread counts and more about helping the user jump into orders, offers, and rewards with zero confusion.
              </p>
            </article>
          </div>
        </section>
      </div>
    </AppShell>
  );
}
