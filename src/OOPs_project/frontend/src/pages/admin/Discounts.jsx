import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Discounts() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin">Back to admin</Button>}
          eyebrow="Admin Discounts"
          title="Control campaigns, coupon states, and offer pressure"
          description="Discount management needs visibility over activation state, expected impact, and where a campaign sits in the conversion funnel."
        />

        <section className="grid gap-4">
          {dummyData.discountCampaigns.map((campaign) => (
            <article key={campaign.id} className="surface-card p-6 md:p-7">
              <div className="flex flex-col gap-4 lg:flex-row lg:items-center lg:justify-between">
                <div>
                  <p className="text-xs font-semibold uppercase tracking-[0.16em] text-brand-600">{campaign.code}</p>
                  <h2 className="mt-2 text-2xl font-semibold text-ink-900">{campaign.note}</h2>
                </div>
                <div className="flex flex-wrap items-center gap-3">
                  <span className="rounded-full bg-ink-50 px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-ink-600">
                    {campaign.state}
                  </span>
                  <span className="rounded-full bg-brand-50 px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] text-brand-600">
                    {campaign.impact} impact
                  </span>
                  <Button tone="secondary">Edit</Button>
                </div>
              </div>
            </article>
          ))}
        </section>
      </div>
    </AppShell>
  );
}
