import { useState } from "react";
import Select from "../../components/common/Select";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";
import formatCurrency from "../../utils/formatCurrency";

export default function PriceCalculator() {
  const [mode, setMode] = useState("single");

  const estimate =
    mode === "premium" ? { subtotal: 5999, savings: 650 } : mode === "bundle" ? { subtotal: 8499, savings: 900 } : { subtotal: 3199, savings: 250 };

  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          eyebrow="Price Calculator"
          title="Estimate order value before entering checkout"
          description="This utility gives users a simplified view of how bundles, member perks, and savings impact the final order amount."
        />

        <section className="grid gap-6 xl:grid-cols-[0.85fr_1.15fr]">
          <article className="surface-card p-7 md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Scenario</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Choose a basket type</h2>
            <div className="mt-8">
              <Select options={dummyData.fareCalculatorPresets} value={mode} onChange={(event) => setMode(event.target.value)} />
            </div>
          </article>

          <article className="rounded-[2rem] bg-gradient-to-br from-brand-500 to-violet-500 p-7 text-white shadow-[0_24px_60px_rgba(54,92,255,0.25)] md:p-8">
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">Estimate</p>
            <h2 className="mt-3 text-3xl font-semibold text-white">Projected checkout value</h2>
            <div className="mt-8 space-y-4">
              <div className="flex items-center justify-between">
                <span className="text-white/80">Estimated subtotal</span>
                <span className="text-2xl font-semibold">{formatCurrency(estimate.subtotal)}</span>
              </div>
              <div className="flex items-center justify-between">
                <span className="text-white/80">Projected savings</span>
                <span className="text-2xl font-semibold">{formatCurrency(estimate.savings)}</span>
              </div>
            </div>
          </article>
        </section>
      </div>
    </AppShell>
  );
}
