import Button from "../common/Button";

export default function AddressForm({ addresses, selectedId, onSelect }) {
  return (
    <article className="surface-card p-6 md:p-7">
      <div className="flex items-end justify-between gap-4">
        <div>
          <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Delivery address</p>
          <h2 className="mt-3 text-3xl font-semibold text-ink-900">Choose where the order should go</h2>
        </div>
        <Button tone="secondary">Add new</Button>
      </div>

      <div className="mt-8 grid gap-4">
        {addresses.map((address) => {
          const isSelected = address.id === selectedId;

          return (
            <button
              key={address.id}
              className={`rounded-[1.75rem] border p-5 text-left transition ${
                isSelected
                  ? "border-brand-300 bg-brand-50 shadow-[var(--shadow-soft-md)]"
                  : "border-ink-100 bg-ink-50 hover:bg-white"
              }`}
              onClick={() => onSelect(address.id)}
              type="button"
            >
              <div className="flex items-start justify-between gap-4">
                <div>
                  <p className="text-lg font-semibold text-ink-900">{address.label}</p>
                  <p className="mt-2 text-sm leading-7 text-ink-600">{address.name}</p>
                  <p className="text-sm leading-7 text-ink-500">{address.line1}</p>
                  <p className="text-sm leading-7 text-ink-500">{address.cityState}</p>
                  <p className="text-sm leading-7 text-ink-500">{address.phone}</p>
                </div>
                <span
                  className={`rounded-full px-3 py-2 text-xs font-semibold uppercase tracking-[0.16em] ${
                    isSelected ? "bg-brand-500 text-white" : "bg-white text-ink-400"
                  }`}
                >
                  {isSelected ? "Selected" : address.type}
                </span>
              </div>
            </button>
          );
        })}
      </div>
    </article>
  );
}
