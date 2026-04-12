const defaultPoints = [28, 52, 41, 66, 58, 83, 76];

export default function PerformanceChart({ points = defaultPoints, title = "Performance curve" }) {
  const width = 320;
  const height = 180;
  const max = Math.max(...points, 1);
  const step = width / Math.max(points.length - 1, 1);

  const path = points
    .map((point, index) => {
      const x = index * step;
      const y = height - (point / max) * (height - 20) - 10;
      return `${index === 0 ? "M" : "L"} ${x} ${y}`;
    })
    .join(" ");

  return (
    <article className="surface-card p-6 md:p-7">
      <p className="text-sm font-semibold uppercase tracking-[0.18em] text-brand-600">{title}</p>
      <div className="mt-8 overflow-hidden rounded-[1.75rem] bg-ink-50 p-4">
        <svg className="h-auto w-full" viewBox={`0 0 ${width} ${height}`} xmlns="http://www.w3.org/2000/svg">
          <defs>
            <linearGradient id="performanceStroke" x1="0%" x2="100%" y1="0%" y2="0%">
              <stop offset="0%" stopColor="#365cff" />
              <stop offset="100%" stopColor="#8b5cf6" />
            </linearGradient>
          </defs>
          <path
            d={path}
            fill="none"
            stroke="url(#performanceStroke)"
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth="8"
          />
          {points.map((point, index) => {
            const x = index * step;
            const y = height - (point / max) * (height - 20) - 10;

            return <circle key={`${point}-${index}`} cx={x} cy={y} fill="#fff" r="6" stroke="#365cff" strokeWidth="3" />;
          })}
        </svg>
      </div>
    </article>
  );
}
