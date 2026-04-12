import Button from "../common/Button";
import Input from "../common/Input";

export default function AddressModal({ open, onClose }) {
  if (!open) {
    return null;
  }

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-ink-900/45 px-4">
      <div className="w-full max-w-2xl rounded-[2rem] bg-white p-7 shadow-[0_30px_80px_rgba(15,23,42,0.25)] md:p-8">
        <div className="flex items-start justify-between gap-4">
          <div>
            <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Address</p>
            <h2 className="mt-3 text-3xl font-semibold text-ink-900">Add a new delivery address</h2>
          </div>
          <button className="text-sm font-semibold text-ink-400 transition hover:text-ink-900" onClick={onClose} type="button">
            Close
          </button>
        </div>

        <div className="mt-8 grid gap-4 md:grid-cols-2">
          <Input placeholder="Full name" />
          <Input placeholder="Phone number" />
          <Input className="md:col-span-2" placeholder="Address line 1" />
          <Input placeholder="City" />
          <Input placeholder="State" />
          <Input placeholder="Postal code" />
          <Input placeholder="Label (Home / Work)" />
        </div>

        <div className="mt-8 flex flex-col gap-3 sm:flex-row">
          <Button className="flex-1">Save address</Button>
          <Button className="flex-1" onClick={onClose} tone="secondary">
            Cancel
          </Button>
        </div>
      </div>
    </div>
  );
}
