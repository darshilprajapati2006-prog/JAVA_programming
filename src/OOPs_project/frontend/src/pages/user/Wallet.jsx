import AppShell from "../../components/layout/AppShell";
import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Wallet() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/app/cart">Use in cart</Button>}
          eyebrow="Wallet"
          title="Rewards, balance, and coupon power"
          description="The wallet should feel like a conversion engine, not just a balance screen. This page combines stored value, reward momentum, and ready-to-use coupon clarity."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.walletSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.05fr_0.95fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Membership tier</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Reward progression</h2>
            <div className="mt-8 rounded-[2rem] bg-gradient-to-br from-ink-900 via-brand-900 to-brand-500 p-7 text-white shadow-[0_24px_70px_rgba(15,23,42,0.24)]">
              <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Current status</p>
              <h3 className="mt-4 text-4xl font-semibold text-white">Silver Tier</h3>
              <p className="mt-3 max-w-xl text-sm leading-7 text-white/80">
                Your current spend pattern places you in the premium repeat-buyer segment. One more high-value order pushes you toward the next reward level.
              </p>
              <div className="mt-8 h-3 rounded-full bg-white/15">
                <div className="h-3 w-[68%] rounded-full bg-white" />
              </div>
              <p className="mt-3 text-sm text-white/72">Rs 16,750 away from Gold tier benefits</p>
            </div>

            <div className="mt-6 grid gap-4 md:grid-cols-3">
              {dummyData.rewardTiers.map((tier) => (
                <div
                  key={tier.label}
                  className={`rounded-[1.5rem] p-5 ${
                    tier.active ? "bg-brand-50 text-brand-700" : "bg-ink-50 text-ink-600"
                  }`}
                >
                  <p className="text-lg font-semibold">{tier.label}</p>
                  <p className="mt-2 text-sm leading-6">{tier.spend}</p>
                </div>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Wallet insights</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Why this page matters</h2>
            <div className="mt-8 space-y-4">
              {dummyData.walletInsights.map((insight, index) => (
                <div key={insight} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
                    0{index + 1}
                  </div>
                  <p className="text-sm leading-7 text-ink-600">{insight}</p>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Coupon stack</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Offers ready to activate</h2>
              </div>
              <Button tone="secondary" to="/app/cart">
                Apply in cart
              </Button>
            </div>

            <div className="mt-8 space-y-4">
              {dummyData.walletCoupons.map((coupon) => (
                <article
                  key={coupon.code}
                  className={`rounded-[1.75rem] bg-gradient-to-br ${coupon.accent} p-6 text-white shadow-[var(--shadow-soft-lg)]`}
                >
                  <div className="flex items-start justify-between gap-4">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.18em] text-white/72">{coupon.code}</p>
                      <h3 className="mt-3 text-2xl font-semibold text-white">{coupon.title}</h3>
                      <p className="mt-3 text-sm leading-7 text-white/82">{coupon.note}</p>
                    </div>
                    <button
                      className="rounded-full bg-white px-4 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-ink-900"
                      type="button"
                    >
                      Use
                    </button>
                  </div>
                </article>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Transaction history</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Movement across balance and rewards</h2>
            <div className="mt-8 space-y-4">
              {dummyData.walletTransactions.map((item) => (
                <div key={item.id} className="rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex items-start justify-between gap-4">
                    <div>
                      <p className="text-lg font-semibold text-ink-900">{item.title}</p>
                      <p className="mt-2 text-sm leading-6 text-ink-500">{item.note}</p>
                      <p className="mt-3 text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">{item.date}</p>
                    </div>
                    <span
                      className={`rounded-full px-3 py-2 text-sm font-semibold ${
                        item.type === "credit" ? "bg-emerald-50 text-emerald-600" : "bg-rose-50 text-rose-600"
                      }`}
                    >
                      {item.amount}
                    </span>
                  </div>
                </div>
              ))}
            </div>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
