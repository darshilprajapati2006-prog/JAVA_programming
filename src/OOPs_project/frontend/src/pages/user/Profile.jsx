import AppShell from "../../components/layout/AppShell";
import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Profile() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/app/wallet">Open wallet</Button>}
          eyebrow="Profile"
          title="Manage your account with clarity"
          description="This profile area brings together identity, addresses, preferences, and account-level trust settings in one clean premium control surface."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.profileSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[0.95fr_1.05fr]">
          <article className="surface-card p-7 md:p-8">
            <div className="rounded-[2rem] bg-gradient-to-br from-ink-900 via-brand-900 to-brand-500 p-8 text-white shadow-[0_24px_70px_rgba(15,23,42,0.24)]">
              <div className="flex items-center gap-4">
                <div className="flex h-20 w-20 items-center justify-center rounded-[2rem] bg-white text-2xl font-semibold text-ink-900 shadow-[var(--shadow-soft-lg)]">
                  {dummyData.currentUser.initials}
                </div>
                <div>
                  <p className="text-3xl font-semibold text-white">{dummyData.profileDetails.name}</p>
                  <p className="mt-2 text-sm text-white/78">{dummyData.profileDetails.memberType}</p>
                </div>
              </div>

              <div className="mt-8 grid gap-4 sm:grid-cols-2">
                <div className="rounded-[1.5rem] bg-white/10 p-5">
                  <p className="text-xs font-semibold uppercase tracking-[0.16em] text-white/70">Email</p>
                  <p className="mt-3 text-sm text-white">{dummyData.profileDetails.email}</p>
                </div>
                <div className="rounded-[1.5rem] bg-white/10 p-5">
                  <p className="text-xs font-semibold uppercase tracking-[0.16em] text-white/70">Phone</p>
                  <p className="mt-3 text-sm text-white">{dummyData.profileDetails.phone}</p>
                </div>
                <div className="rounded-[1.5rem] bg-white/10 p-5">
                  <p className="text-xs font-semibold uppercase tracking-[0.16em] text-white/70">City</p>
                  <p className="mt-3 text-sm text-white">{dummyData.profileDetails.city}</p>
                </div>
                <div className="rounded-[1.5rem] bg-white/10 p-5">
                  <p className="text-xs font-semibold uppercase tracking-[0.16em] text-white/70">Tier</p>
                  <p className="mt-3 text-sm text-white">{dummyData.profileDetails.spendLevel}</p>
                </div>
              </div>
            </div>

            <div className="mt-6 grid gap-3 sm:grid-cols-2">
              <Button>Update profile</Button>
              <Button tone="secondary">Change avatar</Button>
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <div className="flex items-end justify-between gap-4">
              <div>
                <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Saved addresses</p>
                <h2 className="mt-3 text-3xl font-semibold text-ink-900">Your active delivery points</h2>
              </div>
              <Button tone="secondary">Add address</Button>
            </div>

            <div className="mt-8 grid gap-4">
              {dummyData.checkoutAddresses.map((address) => (
                <div key={address.id} className="rounded-[1.75rem] bg-ink-50 p-5">
                  <div className="flex items-start justify-between gap-4">
                    <div>
                      <p className="text-lg font-semibold text-ink-900">{address.label}</p>
                      <p className="mt-2 text-sm leading-7 text-ink-600">{address.name}</p>
                      <p className="text-sm leading-7 text-ink-500">{address.line1}</p>
                      <p className="text-sm leading-7 text-ink-500">{address.cityState}</p>
                      <p className="text-sm leading-7 text-ink-500">{address.phone}</p>
                    </div>
                    <span className="rounded-full bg-white px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-ink-500">
                      {address.type}
                    </span>
                  </div>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Preferences</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Personalization and communication</h2>
            <div className="mt-8 space-y-4">
              {dummyData.profilePreferences.map((item) => (
                <div key={item.label} className="flex items-center justify-between rounded-[1.5rem] bg-ink-50 p-5">
                  <div>
                    <p className="text-base font-semibold text-ink-900">{item.label}</p>
                    <p className="mt-1 text-sm text-ink-500">Account-level setting</p>
                  </div>
                  <div className={`flex h-8 w-14 items-center rounded-full px-1 ${item.enabled ? "bg-brand-500" : "bg-ink-200"}`}>
                    <span className={`h-6 w-6 rounded-full bg-white shadow ${item.enabled ? "ml-auto" : ""}`} />
                  </div>
                </div>
              ))}
            </div>
          </article>

          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Account security</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Trust and device visibility</h2>
            <div className="mt-8 space-y-4">
              {dummyData.profileSecurity.map((item, index) => (
                <div key={item} className="flex gap-4 rounded-[1.5rem] bg-ink-50 p-5">
                  <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-white text-sm font-semibold text-brand-600 shadow-[var(--shadow-soft-md)]">
                    0{index + 1}
                  </div>
                  <p className="text-sm leading-7 text-ink-600">{item}</p>
                </div>
              ))}
            </div>
          </article>
        </section>

        <section className="grid gap-6 xl:grid-cols-[1fr_1fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Quick account actions</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Everything important in one place</h2>
            <div className="mt-8 grid gap-4 sm:grid-cols-2">
              {dummyData.profileActions.map((item) => (
                <button
                  key={item}
                  className="rounded-[1.5rem] bg-ink-50 px-5 py-5 text-left text-base font-semibold text-ink-800 transition hover:bg-white hover:shadow-[var(--shadow-soft-md)]"
                  type="button"
                >
                  {item}
                </button>
              ))}
            </div>
          </article>

          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Account note</p>
            <h2 className="mt-3 text-3xl font-semibold text-white">Profile completes the signed-in system</h2>
            <p className="mt-4 text-sm leading-7 text-white/82">
              After this, the strongest remaining frontend work is public polish: authentication pages and the home landing so the entire product feels launch-ready.
            </p>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
