import ProductCard from "../../components/cards/ProductCard";
import AppShell from "../../components/layout/AppShell";
import PageHeader from "../../components/layout/PageHeader";
import { dummyData } from "../../constants/dummyData";

export default function QuickBuy() {
  return (
    <AppShell>
      <div className="space-y-8">
        <PageHeader
          eyebrow="Quick Buy"
          title="Fast purchase picks for low-friction shopping"
          description="This page is designed for users who already trust the product and want a tighter route from browse to checkout."
        />
        <section className="grid gap-6 md:grid-cols-2">
          {dummyData.quickBuyPicks.map((product) => (
            <ProductCard key={product.slug} product={product} />
          ))}
        </section>
      </div>
    </AppShell>
  );
}
