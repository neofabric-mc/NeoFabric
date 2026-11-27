import hashlib
from pathlib import Path
import sys
import zipfile


def md5(path):
    return hashlib.md5(path.read_bytes()).hexdigest()


def contents(path):
    with zipfile.ZipFile(path) as jar:
        return {
            entry.filename: hashlib.sha256(jar.read(entry)).hexdigest()
            for entry in jar.infolist() if not entry.is_dir()
        }


before, after = map(Path, sys.argv[1:])
print(f"Base: {before.stat().st_size} bytes, MD5 {md5(before)}")
print(f"Branch: {after.stat().st_size} bytes, MD5 {md5(after)}")
if md5(before) != md5(after):
    old, new = contents(before), contents(after)
    differences = [name for name in sorted(old.keys() | new.keys()) if old.get(name) != new.get(name)]
    if differences:
        raise SystemExit("Standard Loader jar payload changed: " + ", ".join(differences[:30]))
    print("ZIP container differs; all uncompressed entries match by SHA-256.")
else:
    print("Standard Loader jars are byte-for-byte identical.")
