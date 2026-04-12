import Button from "../common/Button";

export default function ConfirmModal({
  open,
  title = "Confirm action",
  description = "Please confirm this action before proceeding.",
  confirmLabel = "Confirm",
  cancelLabel = "Cancel",
  onConfirm,
  onCancel,
}) {
  if (!open) {
    return null;
  }

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-ink-900/45 px-4">
      <div className="w-full max-w-lg rounded-[2rem] bg-white p-7 shadow-[0_30px_80px_rgba(15,23,42,0.25)] md:p-8">
        <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">Confirmation</p>
        <h2 className="mt-3 text-3xl font-semibold text-ink-900">{title}</h2>
        <p className="mt-4 text-sm leading-7 text-ink-500">{description}</p>
        <div className="mt-8 flex flex-col gap-3 sm:flex-row">
          <Button className="flex-1" onClick={onConfirm}>
            {confirmLabel}
          </Button>
          <Button className="flex-1" onClick={onCancel} tone="secondary">
            {cancelLabel}
          </Button>
        </div>
      </div>
    </div>
  );
}
