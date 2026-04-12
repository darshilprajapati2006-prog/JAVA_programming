import SalesChart from "../../components/charts/SalesChart";
import SpendingChart from "../../components/charts/SpendingChart";
import PerformanceChart from "../../components/charts/PerformanceChart";
import WalletCard from "../../components/cards/WalletCard";
import Button from "../../components/common/Button";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function Analytics() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          action={<Button to="/admin/discounts">Open discounts</Button>}
          eyebrow="Admin Analytics"
          title="Track growth, spend behavior, and campaign output"
          description="This view packages key commerce performance signals into reusable visual components so the admin side can scale cleanly."
        />

        <section className="grid gap-5 lg:grid-cols-3">
          {dummyData.analyticsSummary.map((item) => (
            <WalletCard key={item.title} {...item} />
          ))}
        </section>

        <section className="grid gap-6 xl:grid-cols-[1.15fr_0.85fr]">
          <SalesChart data={dummyData.analyticsSalesData} title="Monthly sales trajectory" />
          <PerformanceChart points={dummyData.analyticsPerformancePoints} title="Retention performance curve" />
        </section>

        <section className="grid gap-6 xl:grid-cols-[0.9fr_1.1fr]">
          <SpendingChart data={dummyData.analyticsSpendingMix} title="Checkout payment mix" />
          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Analytics note</p>
            <h2 className="mt-3 text-3xl font-semibold text-white">The chart layer is now reusable</h2>
            <p className="mt-4 text-sm leading-7 text-white/82">
              These visual components can now be dropped into admin or user pages without needing a third-party charting library for the mock frontend stage.
            </p>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
