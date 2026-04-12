import Button from "../common/Button";

export default function CollectionCard({ collection }) {
  return (
    <article className={`rounded-[2rem] bg-gradient-to-br ${collection.accent} p-7 text-white shadow-[var(--shadow-soft-lg)] md:p-8`}>
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-white/72">{collection.itemCount}</p>
      <h3 className="mt-5 text-3xl font-semibold tracking-tight text-white">{collection.title}</h3>
      <p className="mt-3 text-sm font-medium text-white/85">{collection.subtitle}</p>
      <p className="mt-4 max-w-md text-sm leading-7 text-white/78">{collection.description}</p>
      <Button className="mt-8" tone="secondary" to="/shop">
        {collection.cta}
      </Button>
    </article>
  );
}
