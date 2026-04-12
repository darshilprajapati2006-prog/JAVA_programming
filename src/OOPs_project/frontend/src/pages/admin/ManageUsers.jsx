import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function ManageUsers() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin/discounts">Open discount engine</Button>}
          eyebrow="Admin Users"
          title="Monitor user health, support, and retention"
          description="This module helps the admin team segment customers, handle support escalations, and identify risk before churn happens."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.adminUsersSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="surface-card p-7 md:p-8">
          <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Customer list</p>
          <h2 className="mt-3 text-3xl font-semibold text-ink-900">Users currently on the admin radar</h2>
          <div className="mt-8 grid gap-4">
            {dummyData.adminUsersList.map((user) => (
              <article key={user.id} className="rounded-[1.75rem] bg-ink-50 p-5">
                <div className="flex flex-col gap-4 lg:flex-row lg:items-center lg:justify-between">
                  <div>
                    <h3 className="text-2xl font-semibold text-ink-900">{user.name}</h3>
                    <p className="mt-2 text-sm text-ink-500">{user.note}</p>
                  </div>
                  <div className="grid gap-3 sm:grid-cols-3 lg:items-center">
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">Segment</p>
                      <p className="mt-2 text-base font-semibold text-ink-900">{user.segment}</p>
                    </div>
                    <div>
                      <p className="text-xs font-semibold uppercase tracking-[0.16em] text-ink-300">Spend</p>
                      <p className="mt-2 text-base font-semibold text-ink-900">{user.spend}</p>
                    </div>
                    <div className="flex items-center gap-3">
                      <span className="rounded-full bg-white px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-ink-500">
                        {user.status}
                      </span>
                      <Button tone="secondary">Inspect</Button>
                    </div>
                  </div>
                </div>
              </article>
            ))}
          </div>
        </section>
      </div>
    </AppShell>
  );
}
