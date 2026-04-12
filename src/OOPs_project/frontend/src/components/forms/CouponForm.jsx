import Button from "../common/Button";
import Input from "../common/Input";

export default function CouponForm({ value, onChange, onApply, successMessage, suggestions = [] }) {
  return (
    <article className="surface-card p-6 md:p-7">
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Coupon zone</p>
      <h2 className="mt-3 text-3xl font-semibold text-ink-900">Apply a premium offer</h2>

      <div className="mt-6 flex flex-col gap-3 sm:flex-row">
        <Input placeholder="Enter coupon code" value={value} onChange={onChange} />
        <Button className="sm:min-w-[140px]" onClick={onApply}>
          Apply
        </Button>
      </div>

      {successMessage ? (
        <div className="mt-4 rounded-[1.25rem] border border-emerald-200 bg-emerald-50 px-4 py-3 text-sm font-medium text-emerald-700">
          {successMessage}
        </div>
      ) : null}

      <div className="mt-6 grid gap-3 sm:grid-cols-2">
        {suggestions.map((coupon) => (
          <button
            key={coupon.code}
            className="rounded-[1.25rem] border border-ink-100 bg-ink-50 px-4 py-4 text-left transition hover:bg-white"
            onClick={() => onChange({ target: { value: coupon.code } })}
            type="button"
          >
            <p className="text-lg font-semibold text-brand-600">{coupon.code}</p>
            <p className="mt-1 text-sm text-ink-500">{coupon.note}</p>
          </button>
        ))}
      </div>
    </article>
  );
}
